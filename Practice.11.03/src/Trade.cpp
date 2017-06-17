#include "Trade.h"

// ----- constructors -------------------------------------------------------

Trade::Trade(const std::string& s,
			 const double p, const int i,
			 const int q)
{
	setSymbol(s);
	setId(i);
	setPrice(p);
	setQuantity(q);
}

Trade::Trade(const Trade& that)
{
	setSymbol(that.getSymbol());
	setId(that.getId());
	setPrice(that.getPrice());
	setQuantity(that.getQuantity());
}

Trade::Trade()
{
}

// ----- accessors ----------------------------------------------------------

std::string Trade::getSymbol() const
{
	return symbol;
}

void Trade::setSymbol(const std::string& s)
{
	symbol = s;
}

int Trade::getId() const
{
	return id;
}

void Trade::setId(const int i)
{
	id = i;
}

double Trade::getPrice() const
{
	return price;
}

void Trade::setPrice(const double p)
{
	price = p;
}

int Trade::getQuantity() const
{
	return quantity;
}

void Trade::setQuantity(const int q)
{
	quantity = q;
}

// ----- free functions -----------------------------------------------------

std::ostream& operator<<(std::ostream& out, const Trade& trade)
{
	out << "Trade("
		<< "Symbol="     << trade.getSymbol()
		<< ", Price=" << trade.getPrice()
		<< ", Id="   << trade.getId()
		<< ", Quantity="  << trade.getQuantity()
		<< ')';
	return out;
}

bool operator==(const Trade& tradeA, const Trade& tradeB)
{
	return tradeA.getSymbol()   == tradeB.getSymbol()   &&
		tradeA.getPrice() == tradeB.getPrice() &&
		tradeA.getId()   == tradeB.getId()   &&
		tradeA.getQuantity()  == tradeB.getQuantity();
}

size_t hash_value(const Trade& trade)
{
	return size_t(&trade); // identity hash (note: not suitable for cache keys)
}