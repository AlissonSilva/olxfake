<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::post('categorias/store', 'App\Http\Controllers\ApiCategoriaController@store');
Route::get('categorias/listar', 'App\Http\Controllers\ApiCategoriaController@index');


Route::post('anuncios/store', 'App\Http\Controllers\ApiAnuncioControlle@store');
Route::get('anuncios/listar', 'App\Http\Controllers\ApiAnuncioControlle@index');
