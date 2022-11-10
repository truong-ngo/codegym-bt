package structural_design_pattern.adapter_deployment;

import com.codegym.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CollectionOperationAdapter implements CollectionOperations {
    @Override
    public int findMax(Set<Integer> numbers) {
        CollectionUtils collectionUtils = new CollectionUtils();
        List<Integer> integers = new ArrayList<>(numbers);
        return collectionUtils.findMax(integers);
    }
}
