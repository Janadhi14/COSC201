package cosc201.a1;

import cosc201.unionfind.UnionFind;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

/**
 * A modified version of this file is the only code you should submit.
 * 
 * You may add methods (and must complete some) but must not make changes
 * to the given data fields or constructor. You may, but should not need to
 * add data fields.
 * 
 * Methods that you need to complete currently just return some value of the
 * correct type. When you've written them they should return the correct answer
 * as described in the javadoc.
 * 
 * All methods should run correctly even if called more than once or in
 * sequence. This may require re-initialisation of the UnionFind data field
 * using its make method.
 * 
 * This is not necessarily the code you will use to carry out your experiments
 * (though it could be part of that). It's designed to test your understanding
 * of the UF data structure, and your ability to integrate that into code.
 * 
 */
public class PoolAnalyser {

  private final Puddles puddles;
  private final UnionFind uf;

  /**
   * Constructs a PoolAnalyser backed by the given UF instance and family of
   * puddles.
   * 
   * @param uf      a UnionFind instance
   * @param puddles a family of puddles
   */
  public PoolAnalyser(UnionFind uf, Puddles puddles) {
    this.uf = uf;
    this.puddles = puddles;
  }

  /**
   * Computes the index starting from 1 of the last essential merge in
   * the given puddles. So, for example, if there are only two puddles
   * this would always return 1 since the first merge is the only essential
   * one.
   * 
   * @return the 1-based index of the last essential merge
   */
  public int lastEssentialMerge() {
    // Complete this code so that the promise in the javadoc above is
    // satisfied.
    return -1;
  }

  /**
   * Computes the index starting from 1 of the first superfluous merge in
   * the given puddles. Note that if the number of puddles is at most two
   * then there are no such merges. In that case it should return -1.
   * 
   * @return the 1-based index of the first superfluous merge
   */
  public int firstSuperfluousMerge() {
    // Complete this code so that the promise in the javadoc above is
    // satisfied.
    return -1;
  }

  /**
   * Computes the number of superfluous merges that take
   * place in the first <code>numberOfMerges</code> merges.
   * 
   * @param numberOfMerges the number of merges to make
   * @return the number of superflous merges among the first
   *         <code>numberOfMerges</code> merges.
   */
  public int countSuperfluousMerges(int numberOfMerges) {
    // Complete this code so that the promise in the javadoc above is
    // satisfied.
    return -1;
  }

  /**
   * Computes the ratio between the total number of superfluous merges
   * and essential merges at the point where the last essential merge
   * takes place.
   * 
   * @return the final ratio between superfluous and essential merges
   *         when the last essential merge takes place.
   */
  public double superfluousRatio() {
    // Complete this code so that the promise in the javadoc above is
    // satisfied.
    return 0.0;
  }

}
