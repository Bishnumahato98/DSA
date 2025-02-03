public class DSA{

    int top=-1;
    int size;
    char stk[];
    DSA(int size){

        stk=new char[size];
        this.size=size;

    }
    void push(char data){
        if(isFull()){
            System.out.println("stack overflow");
        }
        else{
            //top++
            stk[++top]=data;
        }


    }


    char pop(){
        if(isEmpty()){
            System.out.println("Stack underflow");
            return 'e';
        }
        return stk[top--];

    }

    char peek(){
        return stk[top];
    }

    boolean isEmpty(){
        return top==-1;
    }

    boolean isFull(){
        return top==size-1;
    }





 
    // public static void main(String[] args) {
    //     Stacks s=new Stacks(5);
    //     s.push(10);
    //     s.push(20);
    //     System.out.println(s.pop());
    // }
}


// write an algorithm to convert infix expression to prefix and viseversa(Tabulation).
// Write an algorithm to evaluate postfix expression