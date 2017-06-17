// cppexample.cpp : Defines the entry point for the console application.
//
#include "Trade.h"

#include "coherence/lang.ns"

#include "coherence/net/CacheFactory.hpp"
#include "coherence/net/NamedCache.hpp"
#include "coherence/util/HashSet.hpp"

#include "coherence/util/aggregator/Integer64Sum.hpp"
#include "coherence/util/filter/EqualsFilter.hpp"
#include "coherence/util/Filter.hpp"
#include "coherence/util/Hashtable.hpp"
#include "coherence/util/ValueExtractor.hpp"
#include "coherence/util/extractor/PofExtractor.hpp"

#include <iostream>
#include <sstream>
#include <ostream>
#include <string>

using namespace coherence::lang;

using coherence::net::CacheFactory;
using coherence::net::NamedCache;

using coherence::util::aggregator::Integer64Sum;
using coherence::util::ValueExtractor;
using coherence::util::extractor::PofExtractor;
using coherence::util::filter::EqualsFilter;
using coherence::util::Filter;
using coherence::util::Hashtable;

#include <stdlib.h>

#define NUM_TRADES 20

int main(int argc, char** argv)
{
	// Create/get cache handle
	std::cout << "Getting cache..." << std::endl;
	NamedCache::Handle hCache = CacheFactory::getCache("test");
	std::cout << " OK" << std::endl;

	// Put some trades in the cache
	std::string symbols[] = { "ORCL", "MSFT", "IBM", "SAP" };
	Map::Handle hMap = Hashtable::create();
	for(int i = 0; i < NUM_TRADES; i++)
	{
		Trade t1 = Trade(symbols[rand() % 4], rand() % 100, i, rand() % 1000);
		hMap->put(Integer32::create(i), Managed<Trade>::create(t1));
	}
	hCache->putAll(hMap);
	std::cout << "Stored: " << NUM_TRADES << " trades" << std::endl;

	// Get objects back from cache
	std::cout << "Getting objects back from cache..." << std::endl;
	int sum = 0;
	for(int i = 0; i < NUM_TRADES; i++)
	{
		Integer32::Handle hViewKey = Integer32::create(i);
		Managed<Trade>::View vTrade =
			cast<Managed<Trade>::View>(hCache->get(hViewKey));
		std::cout << " The value for " << hViewKey << " is " << vTrade << std::endl;
		if(vTrade->getSymbol() == "ORCL")
		{
			sum += vTrade->getQuantity();
		}
	}
	std::cout << "Total ORCL trades is: " << sum << std::endl;

	// Perform aggregation. Get total number of "ORCL" trades and print the results 
	ValueExtractor::View vQuantityExtractor = PofExtractor::create(typeid(int32_t), TRADE_QUANTITY);
	ValueExtractor::View vSymbolExtractor = PofExtractor::create(typeid(void), TRADE_SYMBOL);
	String::View vSymbol = "ORCL";
	Filter::View vFilter = EqualsFilter::create(vSymbolExtractor, vSymbol);
	Integer64::View vSum = cast<Integer64::View>(
		hCache->aggregate(vFilter,
		Integer64Sum::create(vQuantityExtractor))); 
	std::cout << "Total number of ORCL trades agregated is: " << vSum << std::endl;

	hCache->release();
	std::cout << "Released local resources" << std::endl;

	return 0;
}

