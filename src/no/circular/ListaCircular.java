package no.circular;

public class ListaCircular<T> {

    private No<T> cabeça;
    private No<T> cauda;
    private int TamanhoLista;

    public ListaCircular() {
        this.cauda = null;
        this.cabeça = null;
        this.TamanhoLista = 0;
    }

    public void add(T conteudo){
        No<T> novoNo = new No<>(conteudo);
        if(this.TamanhoLista==0){
            this.cabeça = novoNo;
            this.cauda = this.cabeça;
            this.cabeça.setNoProximo(cauda);
        }else{
            novoNo.setNoProximo((this.cauda));
            this.cabeça.setNoProximo(novoNo);
            this.cauda = novoNo;
        }
        this.TamanhoLista++;
    }

    public void remove(int index){
        if(index >= this.TamanhoLista)
            throw new IndexOutOfBoundsException(("O indice é maior que o tamanho da lista!"));
        No<T> noAuxiliar = this.cauda;
        if(index ==0){
            this.cauda = this.cauda.getNoProximo();
            this.cabeça.setNoProximo(this.cauda);

        }else if(index == 1){
            this.cauda.setNoProximo((this.cauda.getNoProximo()));
        }else{
            for(int i = 0; i < index-1; i++){
                noAuxiliar = noAuxiliar.getNoProximo();
            }
            noAuxiliar.setNoProximo(noAuxiliar.getNoProximo().getNoProximo());
        }
        this.TamanhoLista--;
    }

    public T get(int index){
        return this.getNO(index).getConteudo();
    }

    private No<T> getNO(int index){
        if(this.isEmpty())
            throw new IndexOutOfBoundsException("A lista está vazia!");

        if(index ==0){
            return this.cauda;
        }

        No<T> noAuxiliar = this.cauda;
        for(int i =0; (i < index) && (noAuxiliar != null); i++){
            noAuxiliar = noAuxiliar.getNoProximo();
        }
        return noAuxiliar;
    }

    public boolean isEmpty(){
        return this.TamanhoLista ==0 ? true : false;
    }

    public int size(){
        return this.TamanhoLista;
    }

    @Override
    public String toString() {
        String strRetorno = "";

        No<T> noAuxiliar = this.cauda;
        for(int i = 0; i < this.size(); i++){
            strRetorno += "[no{conteudo=" +noAuxiliar.getConteudo() +"}]" + "--->";
            noAuxiliar = noAuxiliar.getNoProximo();
        }

        strRetorno += this.size() != 0 ?"(Retorna ao inicio)" : "[]";


        return strRetorno;
    }
}
