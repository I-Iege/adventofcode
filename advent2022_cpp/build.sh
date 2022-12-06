if [ -d "build" ]; then rm -Rf build; fi
mkdir build
cmake -B build
cmake --build build