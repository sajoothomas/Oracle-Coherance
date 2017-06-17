package com.oracle.education.coherence.examples;

import java.io.Serializable;

import com.tangosol.util.ValueExtractor;
import com.tangosol.util.aggregator.AbstractAggregator;

public class AverageAggregator extends AbstractAggregator {
	private transient double sum;
	private transient int count;

	public AverageAggregator() {
		// deserialization constructor
	}

	public AverageAggregator(ValueExtractor valueExtractor) {
		super(valueExtractor);
	}

	public AverageAggregator(String propertyName) {
		super(propertyName);
	}

	protected void init(boolean isFinal) {
		sum = 0;
		count = 0;
	}

	protected void process(Object value, boolean isFinal) {
		if (value == null) return;
		if (isFinal) {
			PartialResult pr = (PartialResult) value;
			sum += pr.getSum();
			count += pr.getCount();
		} else {
			sum += ((Number) value).doubleValue();
			count++;
		}
	}

	protected Object finalizeResult(boolean isFinal) {
		if (isFinal) {
			return count == 0 ? null : sum / count;
		} else {
			return new PartialResult(sum, count);
		}
	}

	static class PartialResult implements Serializable {
		private double sum;
		private int count;

		PartialResult(double sum, int count) {
			this.sum = sum;
			this.count = count;
		}

		public double getSum() {
			return sum;
		}

		public int getCount() {
			return count;
		}
	}
}