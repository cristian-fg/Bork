#include <iostream>
#include <thread>
#include <string>
#include <chrono>

void slowPrint(std::string msg, int speed) {
    for (char c : msg) {
        std::cout << c;
        std::cout.flush();
        std::this_thread::sleep_for(std::chrono::milliseconds(speed));
    }
    std::cout << std::endl;
}

int main() {
    slowPrint("Howdy there partner! I haven't seen you around in town!", 50);

    return 0;
}


