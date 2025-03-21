
export interface TipoProducto {
    id: number;
    nombre: string;
    fechaCreacion: string;
    fechaUpdate: string;
    usuarioCreacion: Usuario;
    usuarioUpdate: Usuario | null;
}

export interface Usuario {
    id: number;
    name: string;
    email: string;
}