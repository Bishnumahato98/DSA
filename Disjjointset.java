public class Disjjointset {
    int size[];
    int parent[];
    int vertices;
    Disjjointset(int vertices){
        this.vertices=vertices;
        size=new int[vertices];
        parent=new int[vertices];
        for(int i=0;i<vertices;i++){
            parent[i]=-1;
        }
    }

    void findCycle(int u, int v){
        int uabsroot=find(u);
        int vbasroot=find(v);
        if(uabsroot==vbasroot){
            System.out.println("cycle detected");
        }
        else{
        //add edge to graph
        union(uabsroot,vbasroot);
        }

    }
    void union(int uabsroot, int vbasroot){
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

    int find(int u){
        if(parent[u]==-1){
            return  u;
        }
        return parent[u]=find(parent[u]);
    }
    public static void main(String[] args) {
        Disjjointset d=new Disjjointset(4);
        d.findCycle(0, 1);
        d.findCycle(1, 3);
        d.findCycle(3, 2);
        d.findCycle(0, 2);
    }
}
