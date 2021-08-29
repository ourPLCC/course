#!/usr/bin/python3

"""
This program will print (to standard output) all of the multiplication
rules conforming to the group.dtlg file for a symmetric group on n
elements, where n is given at the beginning of the program.  The integer
value of n must be between 1 and 10, inclusive.

For n=3, the elements of the group are of the form

   pxyz

where xyz is a permutation of the digits 0, 1, and 2, and p is
the _parity_ of the permutation ('e' for even, 'o' for odd). The
multiplication table entries are of the form

   g(prst, puvw, pxyz)

where xyz is the permutation obtained by composing the permutation rst
with the permutation uvw. The identity element of this group is e012.
The alternating group can be obtained from the full symmetric group by
keeping only the even permutations.

For any given n, the number of elements in the group is n!, and so the
multiplication table has size (n!)^2. This means that for n=3, there
are 6 elements in the group, and the multiplication table has 36 entries.

"""

n = 4
all = ()

# generate all permutations of the tuple t
# and append them to the current list, keeping track of the parity, eo:
# eo=0 if even, eo=1 if odd
def perm(t, tt, eo):
    global all
    m = len(t)
    if m == 0:
        tt = tt+(eo,)
        all = all + (tt,)
        return
    for i in range(m):
        x = t[i]
        tl = t[:i]
        tr = t[i+1:]
        perm(tl+tr, tt+(x,), eo)
        eo = 1-eo # the next permutation in order has opposite parity

def strng(tt):
    s = ''   
    eo = tt[-1]
    for i in range(n):
        s += str(tt[i])
    if eo == 0:
        return 'e'+s;
    return 'o'+s

def main():
    t = tuple(range(n))
    perm(t,(),0)
    print("% Symmetric group on {} elements".format(n))
    for i in range(len(all)):
        for j in range(len(all)):
            p1 = all[i]
            p2 = all[j]
            # print('p1='+str(p1))
            # print('p2='+str(p2))
            eo = p1[-1]+p2[-1]
            eo = eo%2;
            p3 = ()
            for k in range(n):
                # compose p1 and p2
                p3 = p3 + (p2[p1[k]],)
            p3 = p3+(eo,)
            # print('p3='+str(p3))
            print("g({},{},{}).".format(strng(p1), strng(p2), strng(p3)))

main()
