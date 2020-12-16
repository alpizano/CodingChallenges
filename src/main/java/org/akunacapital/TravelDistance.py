from math import acos, sin, cos, radians, floor
import math
RADIUS_MILES = 3963

class DestinationCalculator:
    def __init__(self):
        self.p1 = {}
        self.p2 = {}

    def process(self, line: str) -> str:
        line = line.split(":")
        #print(line)
        if line[0] == 'LOC':
            if not self.p1:
                self.p1["latitude"] = (float(line[2])*math.pi)/180
                self.p1["longitude"] = (float(line[3])*math.pi)/180
                return line[1]
            else:
                self.p2["latitude"] = (float(line[2])*math.pi)/180
                self.p2["longitude"] = (float(line[3])*math.pi)/180
                return line[1]
        else:
            line = line[1:]
            #print(line)
            delta_psi = abs(float(self.p1["longitude"]) - float(self.p2["longitude"]))
            #print("Delta psi is: %f" % delta_psi)
            delta_sigma = acos( sin(float(self.p1["latitude"]))*sin(float(self.p2["latitude"])) + cos(float(self.p1["latitude"]))*cos(float(self.p2["latitude"]))*cos(delta_psi))
            #print("Delta sigma is: %f" % delta_sigma)
            distance = RADIUS_MILES * delta_sigma
            int_distance = int(distance)
            #print("distance is: %i" % int(distance))
            line.append(str(int_distance))
            return ':'.join(line)


x = DestinationCalculator()
x.process("LOC:CHI:41.836944:-87.684722")
x.process("LOC:NYC:40.7127:-74.0059")
print(x.process("TRIP:C0FFEE1C:CHI:NYC"))

#print(x.p1)
#print(x.p2)
