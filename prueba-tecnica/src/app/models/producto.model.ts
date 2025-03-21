import { TipoProducto, Usuario } from ".";

export interface Producto {
    id: number;
    nombre: string;
    precio: number;
    stock: number;
    descripcion: string;
    fechaCreacion: string;
    fechaUpdate: string;
    usuarioCreacion: Usuario;
    usuarioUpdate: Usuario | null;
    tipoProducto: TipoProducto
}

export interface ProductoRequest {
    nombre: string;
    precio: number;
    stock: number;
    descripcion: string;
    idTipoProducto: number;
}