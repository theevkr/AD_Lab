import java.util.*;
import java.util.LinkedList;
public class KrushkalMST {
	public static void initialise(int par[]){
        for(int i = 0 ; i < par.length ; i++){
            par[i] = i;
        }
    }
    public static int find( int x , int par[]){
        if(par[x] == x){
            return x;
        }
        return find(par[x], par);
    }
    public static void union(int par[] , int rank[] , int a , int b){
        int parA = find(a, par);
        int parB = find(b, par);
        if(rank[parA] == rank[parB]){
            par[parB] = parA;
            rank[parA]++;
        }else if(rank[parA] < rank[parB]){
            rank[parA] = parB;
        }else{
            par[parB] = parA;
        }
    }
    public static void krushkal(ArrayList <edge> E , int V){
        int par[] = new int[E.size()];
        initialise(par);
        int rank[] = new int[E.size()];
        Collections.sort(E);
        int cost = 0;
        int edges_in_MST = 0;
        for(int i = 0 ; edges_in_MST < V-1 ; i++){
            edge temp = E.get(i);
            int parA = find(temp.src , par);
            int parB = find(temp.dst, par);
            if(parA != parB){
                union(par, rank, temp.src, temp.dst);
                cost = cost + temp.wei;
                edges_in_MST++;
            }
        }
        System.out.println("The total cost of MST : " + cost);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        ArrayList <edge> graph1[] = new ArrayList[9];
        for(int i = 0 ; i < graph1.length ; i++){
            graph1[i] = new ArrayList();
        }
        graph1[0].add(new edge(0, 1, 10));
        graph1[0].add(new edge(0, 2, 20));
        graph1[1].add(new edge(1, 0, 10));
        graph1[1].add(new edge(1, 3, 30));
        graph1[2].add(new edge(2, 0, 20));
        graph1[2].add(new edge(2, 4, 40));
        graph1[3].add(new edge(3, 1, 30));
        graph1[3].add(new edge(3, 4, 50));
        graph1[3].add(new edge(3, 5, 60));
        graph1[4].add(new edge(4, 2, 40));
        graph1[4].add(new edge(4, 3, 50));
        graph1[4].add(new edge(4, 5, 70));
        graph1[5].add(new edge(5, 3, 60));
        graph1[5].add(new edge(5, 4, 70));
        graph1[5].add(new edge(5, 6, 80));
        graph1[6].add(new edge(6, 5, 80));

        ArrayList <edge> E = new ArrayList<>();
        for(int i = 0 ; i < graph1.length ; i++){
            for(int j = 0 ; j < graph1[i].size() ; j++){
                edge temp = graph1[i].get(j);
                if(temp.dst > temp.src){
                    E.add(temp);
                }
            }
        }
        System.out.println(" ");
        krushkal(E, 7);
    }
}
class edge implements Comparable <edge> {
    int src;
    int dst;
    int wei;
    edge(int src , int dst , int wei){
        this.src = src;
        this.dst = dst;
        this.wei = wei;
    }
    public int compareTo(edge temp){
        return this.wei - temp.wei;
    }
}