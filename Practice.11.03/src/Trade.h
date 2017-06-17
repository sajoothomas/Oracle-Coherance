#ifndef TRADE_H
#define TRADE_H

#include <ostream>
#include <string>

// Constants for POF offsets
#define TRADE_SYMBOL 0
#define TRADE_PRICE 1
#define TRADE_ID 2
#define TRADE_QUANTITY 3

/**
* The Trade class encapsulates common information for a Trade.
*
* This serves as an example data object which does not have direct knowledge
* of Coherence but can be stored in the data grid.
*/
class Trade
{

	// ----- data members ---------------------------------------------------

private:
	/**
	* The trade symbos.
	*/
	std::string symbol;

	/**
	* The trade price.
	*/
	double price;

	/**
	* The trade id.
	*/
	int id;

	/**
	* The trade quantity.
	*/
	int quantity;

	// ----- constructors ---------------------------------------------------

public:
	/**
	* Create a new ContactInfo object.
	*
	* @param symbod     the trade symbol
	* @param price      the trade price
	* @param id         the trade id
	* @param quantity   the trade quantity
	*/
	Trade(const std::string& symbol,
		const double price, const int id,
		const int quantity);

	/**
	* Copy constructor.
	*/
	Trade(const Trade& that);

protected:
	/**
	* Default constructor.
	*/
	Trade();


	// ----- accessors ------------------------------------------------------

public:
	/**
	* Determine the symbol for this Trade object
	*
	* @return the Trade symbol
	*/
	std::string getSymbol() const;

	/**
	* Configure the symbol for a Trade.
	*
	* @param sName  the Trades symbol
	*/
	void setSymbol(const std::string& symbol);

	/**
	* Determine the price of a Trade.
	*
	* @return the price of a Trade
	*/
	double getPrice() const;

	/**
	* Configure the price of a Trade.
	*
	* @param price of a Trade
	*/
	void setPrice(const double price);

	/**
	* Determine the id of a Trade.
	*
	* @return the id of a Rrade
	*/
	int getId() const;

	/**
	* Configure the id of a Trade.
	*
	* @param id of a Trade
	*/
	void setId(const int id);

	/**
	* Determine the quantity of a Trade.
	*
	* @return the quantity of a Trade
	*/
	int getQuantity() const;

	/**
	* Configure the quantity of a Trade.
	*
	* @param quantity of a Trade
	*/
	void setQuantity(const int quantity);
};

// ----- free functions -----------------------------------------------------

/**
* Output this Trade to the stream
*
* @param out  the stream to output to
*
* @return the stream
*/
std::ostream& operator<<(std::ostream& out, const Trade& trade);

/**
* Perform an equality test on two Trade objects
*
* @param infoA  the first Trade
* @param infoB  the second Trade
*
* @return true if the objects are equal
*/
bool operator==(const Trade& tradeA, const Trade& tradeB);

/**
* Return the has for the Trade.
*
* @param info  the Trade to hash
*
* @return the hash for the Trade
*/
size_t hash_value(const Trade& trade);

#endif // TRADE_H
