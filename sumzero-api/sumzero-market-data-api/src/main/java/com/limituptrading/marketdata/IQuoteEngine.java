/**
 * MIT License

Copyright (c) 2015  Rob Terpilowski

Permission is hereby granted, free of charge, to any person obtaining a copy of this software 
and associated documentation files (the "Software"), to deal in the Software without restriction, 
including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, 
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING 
BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, 
WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 
*/

package com.limituptrading.marketdata;

import java.util.Date;
import java.util.Properties;

import com.limituptrading.data.Ticker;

public interface IQuoteEngine {

    public static enum Property {
        BID, ASK, MIDPOINT, TRADES
    };

    public static enum Side {
        BID, ASK
    };

    public abstract void subscribeLevel1(Ticker ticker, Level1QuoteListener listener);

    public abstract void unsubscribeLevel1(Ticker ticker, Level1QuoteListener listener);
    
    public abstract void startEngine();

    public abstract void startEngine(Properties props);

    public abstract void stopEngine();

    public abstract void subscribeMarketDepth(Ticker ticker, Level2QuoteListener listener);

    public abstract void unsubscribeMarketDepth(Ticker ticker, Level2QuoteListener listener);

    public abstract Date getServerTime();

    public abstract void addErrorListener(ErrorListener listener);

    public abstract void removeErrorListener(ErrorListener listener);

    public abstract boolean started();
    
    public abstract boolean isConnected();
    
    public void fireLevel1Quote( ILevel1Quote quote );
    
    public void fireMarketDepthQuote( ILevel2Quote quote );
    
    public void fireErrorEvent( QuoteError error );
}
