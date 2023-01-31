package infra.menu.account;

public interface Hash {
    default long geraHash(String str){
        long hash = 0;
        int i =0;
        while((hash < 999999999) && (i < str.length())){
            hash = hash << 8;
            hash += str.charAt(i);
            i++;
        }
        return hash % 100000; // 100000 para evitar colisao
    }
}
