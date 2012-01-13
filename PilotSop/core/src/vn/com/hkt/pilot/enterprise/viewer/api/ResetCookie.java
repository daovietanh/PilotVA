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
public interface ResetCookie extends Cookie {
     public void resetCookie() throws IOException;
    
}
