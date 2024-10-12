public class Combinations77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();

        dfs(1, 0, results, comb, n, k);
        return results;
    }

    // (start, depth, results, comb, n, k)
    // (현재 시작값, 현재 깊이, 최종결과, 현재조합, n, k)
    public void dfs(int start, int depth, List<List<Integer>> results, List<Integer> comb, int n, int k){
        // 만약 조합의 길이가 k가 된 경우
        if(depth == k){
            // results 에 comb 저장
            // 그냥 comb 를 바로 저장하면 안돼고 새로운 리스트를 생성해서 넣어야함
            results.add(comb.stream().toList());
            return;
        }

        for(int i=start; i<=n; i++){
            if(comb.contains(i)){
                continue;
            }
            comb.add(i);
            //중복된 조합이 들어가는것을 방지하기위해 i+1 을 start 로 전달
            dfs(i+1, depth+1, results, comb, n, k);
            comb.remove(comb.size()-1);
        }
    }
}
