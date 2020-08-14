package Controller;

import modelo.ClienteNoCumplio;
import Controller.util.JsfUtil;
import Controller.util.JsfUtil.PersistAction;
import Bean.ClienteNoCumplioFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("clienteNoCumplioController")
@SessionScoped
public class ClienteNoCumplioController implements Serializable {

    @EJB
    private Bean.ClienteNoCumplioFacade ejbFacade;
    private List<ClienteNoCumplio> items = null;
    private ClienteNoCumplio selected;

    public ClienteNoCumplioController() {
    }

    public ClienteNoCumplio getSelected() {
        return selected;
    }

    public void setSelected(ClienteNoCumplio selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ClienteNoCumplioFacade getFacade() {
        return ejbFacade;
    }

    public ClienteNoCumplio prepareCreate() {
        selected = new ClienteNoCumplio();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ClienteNoCumplioCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ClienteNoCumplioUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ClienteNoCumplioDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ClienteNoCumplio> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public ClienteNoCumplio getClienteNoCumplio(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<ClienteNoCumplio> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ClienteNoCumplio> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ClienteNoCumplio.class)
    public static class ClienteNoCumplioControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ClienteNoCumplioController controller = (ClienteNoCumplioController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "clienteNoCumplioController");
            return controller.getClienteNoCumplio(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof ClienteNoCumplio) {
                ClienteNoCumplio o = (ClienteNoCumplio) object;
                return getStringKey(o.getIdclienteNoCumplio());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ClienteNoCumplio.class.getName()});
                return null;
            }
        }

    }

}
