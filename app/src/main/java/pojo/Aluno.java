package pojo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nonilto on 04/09/14.
 * Aluno - Cadastor de alunos
 */
public class Aluno extends DAO {

    private int id;
    private String nome;
    private String endereco;
    private String cidade;
    private String bairro;

    public Aluno() {
        this.dados = new ContentValues();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public List<Aluno> listar(){
        List<Aluno> lista = new ArrayList<Aluno>();
        Cursor qr = this.banco.rawQuery("select * from aluno", new String[]{});
        while(qr.moveToNext()){
            Aluno aluno = new Aluno();
            aluno.setId(qr.getInt(0));
            aluno.setNome(qr.getString(1));
            aluno.setEndereco(qr.getString(2));
            aluno.setCidade(qr.getString(3));
            aluno.setBairro(qr.getString(4));

            lista.add(aluno);
        }

        return lista;
    }

    @Override
    public long salvar(String id) {
      //  this.dados.put("id", this.id);
        this.dados.put("nome", this.nome);
        this.dados.put("endereco", this.endereco);
        this.dados.put("cidade", this.cidade);
        this.dados.put("bairro", this.bairro);

        if (id.equals("")){
           return this.banco.update("aluno", this.dados, " where _id=?", new String[]{id});
        }else
        {
           return this.banco.insert("aluno", null, this.dados);
        }

    }

    @Override
    public long excluir(String id) {
        return this.banco.delete("aluno", "where _id=?", new String[]{id});
    }
}
