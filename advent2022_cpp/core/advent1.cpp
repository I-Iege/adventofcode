#include "advent.h"

#include <vector>
#include <algorithm>
#include <ranges>
#include <numeric>
#include "utils.hpp"

using namespace std;
using namespace utils;

int lib::aoc2022_1_1(const string& filePath)
{
    auto data = readBatches<int>(filePath);
    vector<int> sumValues;
    ranges::transform(data, back_inserter(sumValues), [](auto& it) { return reduce(it.begin(), it.end()); });
    return ranges::max(sumValues);   
}

int lib::aoc2022_1_2(const string& filePath)
{
    auto data = readBatches<int>(filePath);
    vector<int> sumValues;

    ranges::transform(data, back_inserter(sumValues), [](auto& it) { return reduce(it.begin(), it.end()); });
    ranges::sort(sumValues);

    return reduce(sumValues.end() - 3, sumValues.end());
}

int score(pair<char, char> round)
{
	//move value to 0,1,2 interval
	round.second -= 88;
	round.first += 23 - 88;

	int score = round.second + 1;
	if (round.first == round.second)
	{
		score += 3;
	}
	else if (round.second == ((round.first + 1) % 3) )
	{
		score += 6;
	}
	return score;
}

int score2(pair<char, char> round)
{
	//move value to 0,1,2 interval
	round.first += 23 - 88;
	
	switch (round.second)
	{
	case 'Y':
		return 3 + round.first + 1;
	case 'Z':
		return 6 + ( ( round.first + 1) % 3) + 1;
	case 'X':
		return ((round.first + 2) % 3) + 1;
	default:
		return 0;
	}
}

int lib::aoc2022_2_1(const string& filePath)
{
	auto lines = readLines<string>(filePath);
	vector<pair<char, char>> rounds;
	ranges::transform(lines, back_inserter(rounds), [](auto& str) { return make_pair(str[0], str[2]); });
	vector<int> result;
	ranges::transform(rounds, back_inserter(result), &score);
	return reduce(result.begin(), result.end());
}


int lib::aoc2022_2_2(const string& filePath)
{
	auto lines = readLines<string>(filePath);
	vector<pair<char, char>> rounds;
	ranges::transform(lines, back_inserter(rounds), [](auto& str) { return make_pair(str[0], str[2]); });
	vector<int> result;
	ranges::transform(rounds, back_inserter(result), &score2);
	return reduce(result.begin(), result.end());
}