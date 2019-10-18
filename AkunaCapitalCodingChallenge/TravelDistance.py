from math import acos, sin, cos, radians, floor
RADIUS_MILES = 3963

class DestinationCalculator:
    def __init__(self):
        self.list = []

    def process(self, line: str) -> str:
        line = line.split(":")
        print(line)
        self.list.append(line)


x = DestinationCalculator()
x.process("LOC:CHI:41.836944:-87.684722")

