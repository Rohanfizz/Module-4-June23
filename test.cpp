#include<bits/stdc++.h>    
using namespace std;
int sol(string& s){
    //We just need to count adj pairs which are same
    //first and last characters are also treated as adjecent 
    int cnt = 0;
    for(int i = 1;i<s.length();i++){
        if(s[i] == s[i-1]){
            cnt++;
        }
    }

    if(s.length() > 2 && s[0] == s[s.length()-1]) cnt++;
    return cnt;
}

int sol2(vector<int>& A){
    int cprice = 0;
    int cmax = 0;
    int sum = 0;
    int md = 1e9;
    for(int x: A){
        if(x > cmax) cmax = x;//update potential selling point
        else{
            sum = (sum +  (cmax-cprice + md)%md)%md;//selling at cmax and adding profit
            cprice = x;//buying new stock
            cmax = x;
        }
    }
    //last transaction profit is added
    sum = (sum +  (cmax-cprice + md)%md)%md;
    return sum;
}
//helper class to keep track of curr node, 
class helper{
    public:
    int node;
    int cnt;//count of nodes visited in path,
    int odd;// how many odd nodes can we visit
    helper(int  node,int cnt,int odd){
        this->node = node;
        this->cnt = cnt;
        this->odd = odd;
    }
};

int sol3(vector<int>& T){
    int n = T.size();
    //creating graph
    vector<vector<int>> graph(n,vector<int>(0));
    //adding edges
    for(int i = 0;i<n;i++){
        int u = i;
        int v = T[i];

        graph[u].push_back(v);
        graph[v].push_back(u);
    }
    //queue of helper class for bfs traversal
    queue<helper*> q;
    vector<bool> vis(n,false);
    q.push(new helper(0,1,1));
    //will store the final result
    int res = 0;
    while(q.size()){
        helper* curr = q.front(); q.pop();
        int node = curr->node;
        int cnt = curr->cnt;
        int odd = curr->odd;
        //if already visited of curr node is odd OR we have already consumed our odd count, continue
        if(vis[node] || (node%2==1 && odd==0)) continue;
        vis[node] = true;
        //update answer
        res = max(res,cnt);
        //visit unvisited neighbours
        for(int nbr: graph[node]){
            if(!vis[nbr]) q.push(new helper(nbr,cnt+1,odd-(node%2)));
        }
    }
    return res;
}

int main(){
    // string s; cin>>s;
    // vector<int> arr = {1, 2, 3, 4, 5, 3, 2, 1, 4, 5, 6};
    // vector<int> arr = {4,1,2,3};
    // vector<int> arr = {1,2,3,3,2,1,5};
    // vector<int> arr = {1000000000,1,2,2,1000000000,1,1000000000};
    // vector<int> arr = {0,0,0,1,6,1,0,0};
    vector<int> arr = {0,9,0,2,6,8,0,8,3,0};
    cout<<sol3(arr)<<endl;
}