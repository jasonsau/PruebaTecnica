export interface MessageError{
    status: string,
    body: {
        mensaje: string
        codigo: string
    }
}