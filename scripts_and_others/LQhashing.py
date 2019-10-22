import math 

kvs = [15, 54, 13, 10, 135, 114, 49, 174, 27, 24]           # key values list
hashmap = [0]*13                                            # hashmap to be filled with open addressing
hashmap_buckets = [[] for x in range(0,10)]                 # hashmap to be filled with buckets



def get_spot(kv):

    print("Finding spot for kv = %s" % kv)
    c = 0                                                   # collision counter
    ip = kv % len(hashmap)                                  # index val
    q = math.floor(kv / len(hashmap))                       # possible offset

    if(q % len(hashmap) != 0):
        off = q
    else:
        off = 19                                            # our given 4k+3 prime

    print("ip  = %s \nq   = %s \noff = %s" % (ip, q, off))
    hashmap_buckets[kv % len(hashmap_buckets)].append(kv)   # append to buckets at the same time

    while(hashmap[ip] != 0):
        print("Collision found: with %s at %s" % (hashmap[ip], ip))
        ip = (ip + off) % len(hashmap)
        print("ip now %s" % ip)
        c += 1

    print("... goes to index %s of hashmap, count %s \n\n" % (ip, c))
    return ip



def print_map(lst):
    for x in range(0, len(lst)):
        print("[%-2s] | %s" % (x, lst[x]))






for kv in kvs:
    hashmap[get_spot(kv)] = kv

print("Original hashmap:")
print_map(hashmap)

print("\nBucket hashmap:")
print_map(hashmap_buckets)

