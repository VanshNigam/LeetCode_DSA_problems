class Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        # Split version strings into components
        components1 = version1.split('.')
        components2 = version2.split('.')
        
        # Iterate through each component and compare
        for i in range(max(len(components1), len(components2))):
                            
            v1 = int(components1[i]) if i < len(components1) else 0
            v2 = int(components2[i]) if i < len(components2) else 0
            
            if v1 < v2:
                return -1
            elif v1 > v2:
                return 1
        
        # If all components are equal, return 0
        return 0
