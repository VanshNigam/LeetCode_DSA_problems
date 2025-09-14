//not done by me

class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> orig=new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> lowCase=new HashMap<>();
        Map<String, String> vowError=new HashMap<>();
        for(int i=wordlist.length-1;i>=0;i--){
            String word=wordlist[i];
            String wordLow=word.toLowerCase();
            lowCase.put(wordLow,word);
            vowError.put(mask(wordLow),word);
        }
        for(int i=0;i<queries.length;i++){
            String q=queries[i];
            String qLow=q.toLowerCase();
            String qMask=mask(qLow);
            if(orig.contains(q)){
                continue;
            }
            else if(lowCase.containsKey(qLow)){
                queries[i]=lowCase.get(qLow);
            }
            else if(vowError.containsKey(qMask)){
                queries[i]=vowError.get(qMask);
            }
            else{
                queries[i]="";
            }
        }
        return queries;
    }
    public String mask(String s){
        StringBuilder sb=new StringBuilder();
        for(char c:s.toCharArray()){
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
                c='*';
            }
            sb.append(c);
        }
        return sb.toString();
    }
}