def process(line: str) -> str:
    hex = ""
    check_sum = ""
    sum = 0
    new_sum = 0
    new_hex = ""
    tmp_int = 0
    tmp_str = ""

    # extract hex string
    #for elem in line[2:len(line):1]:
     #   hex = elem + hex

    # extract hex string
    for i in range(len(line)):
        if i < 2:
            check_sum = check_sum + line[i]
        elif i >= 2:
            hex =  line[i] + hex

    print(check_sum)
    print(hex)

    # calc hex to decimal number
    for i in range(len(hex)):
        if hex[i] == 'A':
            value = 10
        elif hex[i] == 'B':
            value = 11
        elif hex[i] == 'C':
            value = 12
        elif hex[i] == 'D':
            value = 13
        elif hex[i] == 'E':
            value = 14
        elif hex[i] == 'F':
            value = 15
        else:
            value = int(hex[i])
        sum = sum + value*16**i

    print(sum)

    # split decimal number
    list = str(sum).split()

    for val in str(sum):
        new_sum = new_sum + int(val)

    print(new_sum)

    while(new_sum > 0):
        tmp_int = (new_sum % 16)
        if tmp_int == 10:
            tmp_str = 'A'
        elif tmp_int == 11:
            tmp_str = 'B'
        elif tmp_int == 12:
            tmp_str = 'C'
        elif tmp_int == 13:
            tmp_str = 'D'
        elif tmp_int == 14:
            tmp_str = 'E'
        elif tmp_int == 15:
            tmp_str = 'F'
        else:
            tmp_str = str(tmp_int)
        new_hex = tmp_str + new_hex
        new_sum = int(new_sum / 16)
        print(new_sum)

    print(new_hex)
    return hex

def main():
    print(process("BADF00D5"))


if __name__ == '__main__':
    main()
