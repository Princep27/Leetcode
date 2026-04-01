class Node{
    int pos;
    int val;
    char dir;
    int inPos;

    Node(int pos,int val,char dir,int inPos){
        this.pos = pos;
        this.val = val;
        this.dir = dir;
        this.inPos = inPos;
    }
}

class Solution {

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        
        ArrayList<Node> arr = new ArrayList<>();
        Stack<Node> st = new Stack<Node>();
        List<Node> unorderedAns = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<positions.length;++i) 
            arr.add(new Node(positions[i],healths[i],directions.charAt(i),i));
        Collections.sort(arr,(a,b)->a.pos-b.pos);

        for(int i=0;i<positions.length;++i){
            Node node = arr.get(i);

            if(st.empty()){
                st.push(node);
            }
            else if(st.peek().dir == 'R' && node.dir == 'L'){
                if(node.val < st.peek().val){
                    Node tmp = st.peek(); 
                    st.pop();
                    --tmp.val;
                    st.push(tmp);
                }
                else if(node.val > st.peek().val){
                    while(!st.isEmpty() && st.peek().dir == 'R' && node.val > st.peek().val){
                        st.pop(); --node.val;
                    }

                    if(st.isEmpty()){
                        st.push(node);
                    }
                    else if(st.peek().dir == 'R'){
                        if(node.val == st.peek().val){
                            st.pop(); // both destroyed
                        } 
                        else if(node.val < st.peek().val){
                            Node tmp = st.pop();
                            tmp.val--;
                            st.push(tmp);
                        }
                    }
                    else{
                        st.push(node);
                    }
                    
                }else{
                    st.pop();
                }
            }else{
                st.push(node);
            }
        }

        while(!st.isEmpty()){
            unorderedAns.add(st.peek());
            st.pop();
        }

        Collections.sort(unorderedAns, (a,b)->a.inPos-b.inPos);
        
        for(int i=0;i<unorderedAns.size();++i) ans.add(unorderedAns.get(i).val);

        return ans;
    }
}