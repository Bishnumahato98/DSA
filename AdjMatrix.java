import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class AdjMatrix{

    //mst
    public static class  Edge implements Comparable<Edge>{
        int u;
        int v;
        int w;
        Edge(int u, int v, int w){
            this.u=u;
            this.v=v;
            this.w=w;
        }
        @Override
        public int compareTo(Edge o) {
            return this.w-o.w;
        }
    }
    //mst end
    int [][] matrix;
    int vertices;

    Edge [] edges;//mst
    int edgeindx=-1;//mst

    AdjMatrix(int vertices){
        this.vertices=vertices;
        matrix=new int[vertices][vertices];
        edges=new Edge[vertices*(vertices-1)/2];
    }


    void addEdges(int u, int v, int w){
        matrix[u][v]=w;
        matrix[v][u]=w;
        edges[++edgeindx]=new Edge(u, v, w);//mst adding edge to list
    }
//mst start
    void krushkalAlgortihm(){
        int parent[]=new int[vertices];
        int size[]=new int[vertices];
        int mst[][]=new int[vertices][vertices];
        for(int i=0;i<vertices;i++){
            parent[i]=-1;
        }
        Arrays.sort(edges);
        int edgeTaken=0;
        int edgeCounter=-1;
        while(edgeTaken<vertices){
            Edge e=edges[++edgeCounter];
            int uabsroot=find(e.u,parent);
            int vbasroot=find(e.v,parent);
            if(uabsroot==vbasroot){
                //cycle detected
                continue;
            }
            mst[e.u][e.v]=e.w;
            mst[e.v][e.u]=e.w;
            union(uabsroot, vbasroot, parent, size);
            edgeTaken++;
        }

    }
    void union(int uabsroot, int vbasroot,int [] parent, int size[]){
        if(size[uabsroot]>size[vbasroot]){
            parent[vbasroot]=uabsroot;
        }
        else if(size[uabsroot]<size[vbasroot]){
            parent[uabsroot]=vbasroot;

        }
        else{
            parent[uabsroot]=vbasroot;
            size[vbasroot]++;
        }
    }

    int find(int u,int parent[]){
        if(parent[u]==-1){
            return  u;
        }
        return parent[u]=find(parent[u],parent);
    }
    //mst end

    void printGraph(){        
        for(int i=0;i<vertices;i++){
            //row
            System.out.print(i+" is connected to ");
            for(int j=0;j<vertices;j++){
                //column
                if(matrix[i][j]!=0){
                    //i,j are connected 
                    System.out.print(j+", ");
                }
            }
            System.out.println();
        }
    }

    List<Integer> getAdjNodes(int i){
        List<Integer> adjnodes=new ArrayList<>();
                for(int j=0;j<vertices;j++){
                    //column
                    if(matrix[i][j]!=0){
                        //i,j are connected 
                    adjnodes.add(j);
                    }
                }
        return adjnodes;
    }

    //print matrix

    //breadth first search

    void BFS(int source){
    Queues q=new Queues(vertices);
    boolean visited[]=new boolean[vertices];
    q.enqueue(source);
    visited[source]=true;
    while(!q.isEmpty()){
        int x=q.dequeue();
        System.out.println(x);
        //call getAdjNodes function and  iterate through list
        for(int j=0;j<vertices;j++){
            if(matrix[x][j]!=0){
                if(!visited[j]){
                    q.enqueue(j);
                    visited[j]=true;
                }
            }
        }

    }

    }

    int dijakstra(int source, int destination){

        int dist[]=new int[vertices];
        int prevpath[]=new int[vertices];
        boolean visited[]=new boolean[vertices];
        for(int i=0;i<vertices;i++){
            dist[i]=Integer.MAX_VALUE;
            prevpath[i]=-1;
        }
        dist[source]=0;

        for(int i=0;i<vertices;i++){
            //find min vertex
            int minvertex=findMinvertex(dist,visited);
            visited[minvertex]=true;
            for(int j=0;j<vertices;j++){
                if(matrix[minvertex][j]!=0){
                    if(!visited[j]&&dist[minvertex]+matrix[minvertex][j]<dist[j]){
                        dist[j]=dist[minvertex]+matrix[minvertex][j];
                        prevpath[j]=minvertex;
                    }
                }
            }
        }

        //print path
        int x=destination;
        Stack<Integer> stk=new Stack<>();
        stk.push(x);
        while(prevpath[x]!=-1){
            x=prevpath[x];
            stk.push(x);
        }
        while(!stk.isEmpty()){
            System.out.println(stk.pop());
        }

        return dist[destination];
    }

    int findMinvertex(int [] dist, boolean [] visited){

        int min=-1;
        for(int i=0;i<vertices;i++){
            if(min==-1&&!visited[i] || dist[i]<dist[min]&&!visited[i]){
                min=i;
            }
        }
        return min;
    }

    public static void main(String [] args){
        AdjMatrix adj=new AdjMatrix(6);
        adj.addEdges(0,1,10);
        adj.addEdges(0,5,100);
        adj.addEdges(0,2,5);
        adj.addEdges(1,2,2);
        adj.addEdges(1,3,5);
        adj.addEdges(2,3,10);
        adj.addEdges(2,4,20);
        adj.addEdges(3,5,2);
        adj.addEdges(4,5,5);

        adj.printGraph();
    }

}