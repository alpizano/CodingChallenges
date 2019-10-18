from math import acos, sin, cos, radians, floor
RADIUS_MILES = 3963

class DestinationCalculator:
    def __init__(self):
        self.p1 = {}
        self.p2 = {}

    def process(self, line: str) -> str:
        line = line.split(":")
        print(line)
        if line[0] == 'LOC':
            if not self.p1:
                self.p1["latitude"] = line[2]
                self.p1["longitude"] = line[3]
            else:
                self.p2["latitude"] = line[2]
                self.p2["longitude"] = line[3]




x = DestinationCalculator()
x.process("LOC:CHI:41.836944:-87.684722")
x.process("LOC:NYC:40.7127:-74.0059")

print(x.p1)
print(x.p2)
