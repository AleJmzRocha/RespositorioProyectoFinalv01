package daoentidades;

import entidades.Administrador;

/**
 *
 * @author nga_a
 */
public interface AdministradorDAO {
    public void NuevoAdministrador(Administrador administrador);
    public Boolean entrarAdministradorId(String idAministrador, String cod);
}
