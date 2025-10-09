class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) return node;
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return ulp;
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;

        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> acc) {
        int n = acc.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String, Integer> mp = new HashMap<>();

        // \U0001f4e8 Map each email to account index
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < acc.get(i).size(); j++) {
                String mail = acc.get(i).get(j);
                if (!mp.containsKey(mail))
                    mp.put(mail, i);
                else
                    ds.unionBySize(i, mp.get(mail));
            }
        }

        // \U0001f4e6 Merge mails
        ArrayList<String>[] mergedMail = new ArrayList[n];
        for (int i = 0; i < n; i++) mergedMail[i] = new ArrayList<>();

        for (Map.Entry<String, Integer> it : mp.entrySet()) {
            String mail = it.getKey();
            int node = ds.findUPar(it.getValue());
            mergedMail[node].add(mail);
        }

        // ✅ Prepare final result
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mergedMail[i].size() == 0) continue;

            Collections.sort(mergedMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(acc.get(i).get(0)); // name
            temp.addAll(mergedMail[i]);
            ans.add(temp);
        }
        return ans;
    }
}
