/*
 * Generated by the Mule project wizard. http://mule.mulesoft.org
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.case5356;

import org.mule.api.MuleMessage;
import org.mule.api.client.MuleClient;
import org.mule.dto.CustomDTO;
import org.mule.tck.junit4.FunctionalTestCase;
import org.mule.transport.NullPayload;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class Case5356TestCase extends FunctionalTestCase
{
    protected String getConfigResources()
    {
        //TODO You'll need to edit this file to make the test applicable to your module
        return "case5356-functional-test-config.xml";
    }

    @Test
    public void case5356() throws Exception
    {
        MuleClient client = muleContext.getClient();

        /* create the DTOs */
        CustomDTO dto1 = new CustomDTO(1, "firstDTO");
        CustomDTO dto2 = new CustomDTO(2, "secondDTO");
        CustomDTO dto3 = new CustomDTO(2, "thirdDTO");
        CustomDTO dto4 = new CustomDTO(1, "fourthDTO");


        client.dispatch("vm://entryOneVM", dto1, null);
        client.dispatch("vm://entryOneVM", dto2, null);
        client.dispatch("vm://entryTwoVM", dto3, null);
        client.dispatch("vm://entryTwoVM", dto4, null);

        MuleMessage result = client.request("vm://out", RECEIVE_TIMEOUT);
        assertNotNull(result);
        assertNull(result.getExceptionPayload());
        assertFalse(result.getPayload() instanceof NullPayload);
    }
}
