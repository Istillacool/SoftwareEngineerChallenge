package com.subash;


import java.util.NoSuchElementException;

public class ImmutableQueue<T> implements Queue<T>
{
    private final T[] data;

    public ImmutableQueue(T[] data)
    {
        this.data = data;
    }

    public ImmutableQueue()
    {
        data = (T[]) new Object[0];
    }

    @Override
    public ImmutableQueue<T> enQueue(T t)
    {
        T[] newData = (T[]) new Object[data.length + 1];
        System.arraycopy(data, 0, newData, 0, data.length);
        newData[data.length] = t;
        return new ImmutableQueue<>(newData);
    }

    @Override
    public Queue<T> deQueue()
    {
        if (isEmpty())
        {
            new NoSuchElementException("Empty Queue");
        }
        T[] newData = (T[]) new Object[data.length - 1];
        System.arraycopy(data, 1, newData, 0, data.length - 1);
        return new ImmutableQueue<>(newData);

    }

    @Override
    public T head()
    {
        if (isEmpty())
        {
            new NoSuchElementException("Empty Queue");
        }
        return data[0];
    }

    @Override
    public boolean isEmpty()
    {
        return data.length == 0;
    }
}
