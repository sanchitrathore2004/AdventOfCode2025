    package Day8;

    import java.util.Collections;
    import java.util.Vector;

    public class DSU {
        private Vector<Long> parent;
        private Vector<Long> size;
        public DSU (int n) {
            parent = new Vector<>();
            size = new Vector<>();
            for(int i=0;i<n;i++) {
                parent.add((long) i);
                size.add(1L);
            }
        }
        public long findUPar(long node) {
            if (parent.get((int) node) == node)
                return node;
            long root = findUPar(parent.get((int) node));
            parent.set((int) node, root);
            return root;
        }

        public void unionBySize (long u, long v){
            long ulp_u=findUPar(u);
            long ulp_v=findUPar(v);
            if (ulp_u == ulp_v) return;
            if (size.get((int)ulp_u) > size.get((int)ulp_v)) {
                parent.set((int)ulp_v, ulp_u);
                size.set((int)ulp_u, size.get((int)ulp_u) + size.get((int)ulp_v));
            }
            else {
                parent.set((int)ulp_u, ulp_v);
                size.set((int)ulp_v, size.get((int)ulp_v) + size.get((int)ulp_u));
            }
        }
        public long topThreeSize () {
            Vector<Long> temp = new Vector<>(size);
            temp.sort((a, b) -> Long.compare(b, a));
            System.out.println(temp);
            return temp.get(0)*temp.get(1)*temp.get(2);
        }
        public int fullyConnected() {
            for (int i = 0; i < parent.size(); i++) {
                if (parent.get(i) == i && size.get(i) == parent.size())
                    return 1;
            }
            return -1;
        }
    }
