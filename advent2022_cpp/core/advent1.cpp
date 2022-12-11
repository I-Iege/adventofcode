#include "advent.h"

#include <vector>
#include <algorithm>
#include <ranges>
#include <numeric>
#include "utils.hpp"
#include <set>

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
	round.second -= 88;

	// +2 mod 3 == loose
	// +0 mod 3 == draw
	// +1 mod 3 == win 
	int moduloClass = (round.second + 2) % 3;

	return round.second * 3 + ( (round.first + moduloClass) % 3) + 1;
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



vector<set<char>> toSet(vector<string> lines)
{
	vector<set<char>>  setList;
	ranges::transform(lines, back_inserter(setList), [](auto& it) {
		set<char> set(it.begin(), it.end());
		return set;
	});
	return setList;
}

vector<vector<set<char>>> toSack2(vector<string> lines)
{
	int i = 1;
	vector<vector<set<char>>> sacks;
	vector<string> sack;
	for (auto& line : lines)
	{
		
		sack.push_back(line);
		if (i % 3 == 0)
		{
			sacks.push_back(toSet(sack));
			sack.clear();
		}
		++i;
	}
	return sacks;
}


vector<set<char>> toSack(string& line)
{
	vector<set<char>> sacks;
	unsigned half = line.size()/2;
	std::set<char> first(line.begin(), line.end() - half );
	std::set<char> second(line.end() - half, line.end());
	return { first, second };
}


char toIntersect(vector< set<char>>& sacks)
{
	set<char> intersect;
	auto leftSack = sacks[0];
	for (int i = 1; i < ssize(sacks); ++i)
	{
		intersect.clear();
		ranges::set_intersection(leftSack, sacks[i],inserter(intersect, intersect.end()) );
		leftSack.clear();
		ranges::for_each(intersect, [&leftSack](auto& it) {
			leftSack.insert(it);
		});
		
	}
	
	return *intersect.begin();
}

int toCode(char ch)
{
	if (ch >= 97 && ch <= 122)
	{
		return ch - 96;
	}
	else
	{
		return ch - 38;
	}
}


int lib::aoc2022_3_1(const string& filePath)
{
	auto lines = readLines<string>(filePath);
	vector<vector<set<char>>> sacks;
	ranges::transform(lines, back_inserter(sacks), &toSack);

	vector<char> intersects;
	ranges::transform(sacks, back_inserter(intersects), &toIntersect);

	vector<int> codes;
	ranges::transform(intersects, back_inserter(codes), &toCode);
	return reduce(codes.begin(), codes.end());
}


int lib::aoc2022_3_2(const string& filePath)
{
	auto lines = readLines<string>(filePath);
	auto sacks = toSack2(lines);

	vector<char> intersects;
	ranges::transform(sacks, back_inserter(intersects), &toIntersect);
	
	vector<int> codes;
	ranges::transform(intersects, back_inserter(codes), &toCode);
	return reduce(codes.begin(), codes.end());
}