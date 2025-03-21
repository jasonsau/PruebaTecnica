import { TipoProducto, Usuario } from "./tipo-producto.model";

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