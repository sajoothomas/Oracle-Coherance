/**
* This file defines serializers for the Trade class and registers its
* managed form (Managed<ContactInfo>) with Coherence.
*/
#include "coherence/lang.ns"

#include "coherence/io/pof/PofWriter.hpp"
#include "coherence/io/pof/PofReader.hpp"
#include "coherence/io/pof/SystemPofContext.hpp"
#include "coherence/lang/Float64.hpp"

#include "Trade.h"

#include <string>

using namespace coherence::lang;

using coherence::io::pof::PofReader;
using coherence::io::pof::PofWriter;


COH_REGISTER_MANAGED_CLASS(1001, Trade);


template<> void serialize<Trade>(PofWriter::Handle hOut, const Trade& trade)
{
	hOut->writeString(TRADE_SYMBOL, trade.getSymbol());
	hOut->writeFloat64(TRADE_PRICE, trade.getPrice());  //Float64::valueOf(trade.getPrice()));
	hOut->writeInt32(TRADE_ID, trade.getId());
	hOut->writeInt32(TRADE_QUANTITY, trade.getQuantity());
}

template<> Trade deserialize<Trade>(PofReader::Handle hIn)
{
	std::string symbol = hIn->readString(TRADE_SYMBOL);
	double price = hIn->readFloat64(TRADE_PRICE);
	int id   = hIn->readInt32(TRADE_ID);
	int quantity  = hIn->readInt32(TRADE_QUANTITY);
	return Trade(symbol, price, id, quantity);
}
