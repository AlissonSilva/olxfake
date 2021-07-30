<?php

namespace App\Http\Controllers;

use App\Models\Categoria;
use Illuminate\Http\Request;

class ApiCategoriaController extends Controller
{
    public function index()
    {
        $categoria = Categoria::all();
        return $categoria;
    }

    public function store(Request $request)
    {
        try {
            $dados = $request->all();
            $categoria = new Categoria();
            $categoria->descricao = $request->descricao;
            $categoria->icon_categoria = $request->icon_categoria;
            $categoria->save();
            return ['success' => true];
        } catch (\Throwable $th) {
            return ['error' => $th->getMessage()];
        }
    }
}
