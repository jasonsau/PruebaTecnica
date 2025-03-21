import { Usuario } from "./usuario.model";

export interface TipoProducto {
    id: number;
    nombre: string;
    fechaCreacion: string;
    fechaUpdate: string;
    usuarioCreacion: Usuario;
    usuarioUpdate: Usuario | null;
}
