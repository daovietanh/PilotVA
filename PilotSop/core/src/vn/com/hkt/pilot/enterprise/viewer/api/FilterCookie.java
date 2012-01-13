/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.pilot.enterprise.viewer.api;

import java.io.IOException;
import org.openide.nodes.Node.Cookie;

/**
 *
 * @author longnt
 */
public interface FilterCookie extends Cookie {

    public void filterID(String tk) throws IOException;

    public void filterName(String tk) throws IOException;
}
