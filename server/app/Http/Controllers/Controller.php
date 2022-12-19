<?php

namespace App\Http\Controllers;

use Illuminate\Foundation\Auth\Access\AuthorizesRequests;
use Illuminate\Foundation\Bus\DispatchesJobs;
use Illuminate\Foundation\Validation\ValidatesRequests;
use Illuminate\Routing\Controller as BaseController;

    /**
     * @OA\OpenApi(
     *
     *     @OA\Info(
     *         version="2.0",
     *         title="Olx Fake",
     *         description="Projeto do OLX Fake.",
     *     ),
     * )
     */
class Controller extends BaseController
{
    use AuthorizesRequests, DispatchesJobs, ValidatesRequests;
}
