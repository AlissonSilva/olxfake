<?php

namespace App\Http\Controllers;

use App\Models\Anuncio;
use Illuminate\Http\Request;

class ApiAnuncioControlle extends Controller
{
 /**
 * @OA\Get(
 *     path="/",
 *     description="Home page",
 *     @OA\Response(response="default", description="Welcome page")
 * )
 */
    public function index()
    {
        return Anuncio::all();
    }

    public function store(Request $request)
    {
        try {
            $anuncio = new Anuncio();
            $anuncio->titulo = $request->titulo;
            $anuncio->descricao = $request->descricao;
            $anuncio->id_usuario = $request->id_usuario;
            $anuncio->valor = $request->valor;
            $anuncio->id_categoria = $request->id_categoria;
            $anuncio->telefone1 = $request->telefone1;
            $anuncio->telefone2 = $request->telefone2;
            $anuncio->img_principal = $request->img_principal;
            $anuncio->data_hora_cadastro = $request->data_hora_cadastro;
            $anuncio->save();
            return ['success' => true];
        } catch (\Throwable $th) {
            return ['error' => $th->getMessage()];
        }
    }
}
