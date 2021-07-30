<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Anuncio extends Model
{
    protected $fillable = ['descricao', 'titulo', 'id_usuario', 'valor', 'id_categoria', 'telefone1', 'telefone2', 'img_principal', 'data_hora_cadastro'];
}
