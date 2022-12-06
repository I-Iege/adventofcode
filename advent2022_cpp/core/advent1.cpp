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
	int score = 132 - round.second;
	round.first += 29;
	if (round.first == round.second)
	{
		score += 3;
	}
	else if (round.second == (round.first + 1)
		|| (round.second == 'Z' && round.first == 'X'))
	{
		score += 6;
	}
	return score;
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