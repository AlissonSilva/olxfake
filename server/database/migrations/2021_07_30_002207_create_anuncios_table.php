<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateAnunciosTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('anuncios', function (Blueprint $table) {
            $table->increments('id_anuncio');
            $table->string('titulo', 255);
            $table->string('descricao', 255);
            $table->integer('id_usuario')->default(1);
            $table->float('valor')->default(0.00);
            $table->integer('id_categoria')->unsigned()->default(1);
            $table->string('telefone1', 100)->nullable();
            $table->string('telefone2', 100)->nullable();
            $table->string('img_principal', 255)->default('olxfake.png')->nullable();
            $table->string('data_hora_cadastro', 100)->nullable();
            $table->foreign('id_categoria')->references('id_categoria')->on('categorias')->onDelete('cascade');
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('anuncios');
    }
}
