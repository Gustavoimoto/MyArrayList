package ListaLineares;

import java.util.ArrayList;

public class MyArrayList<E> {
    Object[] data;
    int size;
    int capacity;

        //Crio o contrutor padrão
        public MyArrayList(){
            this.data = new Object[10];
            this.size = 0;
        }

        //Crio o construtor com parâmetro que vai definir o tamanho da lista
        public MyArrayList(int capacity){
            this.data = new Object[capacity];
            this.size = 0;
        }

        public void myAdd(E e){
            if(size == data.length){
                int newCapacity = data.length + (data.length / 2);

                Object[] newData = new Object[newCapacity];

                for (int i = 0; i<  size; i++){
                    newData[i] = data[i];
                }

                data = newData;
            }
            data[size]= e;
            size++;
        }

        public void myAdd(int index, E e){
            if (index < 0 || index> size){
                throw new IndexOutOfBoundsException("Índice inválido: " + index);
            }

            if(size == data.length){
                int newCapacity = data.length + (data.length / 2);

                Object[] newData = new Object[newCapacity];

                for (int i = 0; i<  size; i++){
                    newData[i] = data[i];
                }

                data = newData;
            }

            if (index >= 0 && index<=size){
                for (int i = size; i>index; i--){
                    data[i] = data[i-1];
                }
            }

            data[index] = e;
            size++;
        }

        public E myRemove(int index){
            if (index < 0 || index> size){
                throw new IndexOutOfBoundsException("Índice inválido: " + index);
            }

            E oldValue = (E) data[index];


            for (int i = index; i<size - 1; i++){
                data[i] = data[i + 1];
            }

            size--;
            data[size]=null;

            return oldValue;
        }

        public boolean myRemove(Object o){
            for(int i = 0; i<size; i++){
                if (o == null) {
                    if (data[i] == null) {
                        myRemove(i);
                        return true;
                    }
                } else if (o.equals(data[i])) {
                    // Remove o elemento no índice encontrado
                    myRemove(i);
                    return true; // Retorna true porque a remoção foi bem-sucedida
                }
            }
            return false;
        }

        public E mySet(int index, E e){
            if (index < 0 || index> size){
                throw new IndexOutOfBoundsException("Índice inválido: " + index);
            }

            E oldvalue = (E) data[index];

            data[index] = e;

            return oldvalue;
        }

        public E myGet(int index){
            if (index < 0 || index> size){
                throw new IndexOutOfBoundsException("Índice inválido: " + index);
            }

            E returnvalue = (E) data[index];

            return returnvalue;
        }

        public boolean myContains(Object o){
            for (int i = 0; i<size; i++){
                if (o ==  null){
                    if(data[i] == null){
                        return true;
                    }
                } else if (o.equals(data[i])) {
                    return true;
                }
            }
            return false;
        }

        public int myIndexOf(Object o){
            for (int i = 0; i<size; i++){
                if (o ==  null){
                    if(data[i] == null){
                        return i;
                    }else {
                        if (o.equals(data[i])){
                            return i;
                        }
                    }
                }
            }
            return -1;
        }

        public Object myToArray(){
            Object[] newArray = new Object[size];

            for (int i = 0; i<size; i++){
                newArray[i] = data[i];
            }

            return newArray;
        }
}
