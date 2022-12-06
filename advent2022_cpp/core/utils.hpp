#pragma once

#include <vector>
#include <string>
#include <fstream>

template<typename T>
T convert(const std::string& str)
{
	return (T)str;
}

template<>
int convert(const std::string& str)
{
	return std::stoi(str);
}

namespace utils
{
    template<class T> 
    std::vector<std::vector<T>> readBatches(const std::string& fileName)
    {
        std::vector<std::vector<T>> data;
        std::ifstream f(fileName);
        
        for (std::string line; std::getline(f, line);)
        {
            if (line.empty())
            {
                data.push_back({});
            }
            else 
            {
                if (data.empty())
                {
                    data.push_back({});
                }

                data.back().push_back(convert<T>(line));
            }
        }
        return data;
    }

    template<class T>
    std::vector<T> readLines(const std::string& fileName)
    {
        std::ifstream f(fileName);
        std::vector<T> lines;
        for (std::string line; std::getline(f, line);)
        {
            lines.push_back(convert<T>(line));
        }

        return lines;
    }

}