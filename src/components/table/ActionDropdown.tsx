import { useEffect, useRef } from 'react';
import { MoreVertical, Eye, Edit, Trash2 } from 'lucide-react';

interface ActionDropdownProps {
  isOpen: boolean;
  onToggle: () => void;
  onView?: () => void;
  onEdit?: () => void;
  onDelete?: () => void;
}

export function ActionDropdown({ 
  isOpen, 
  onToggle, 
  onView, 
  onEdit, 
  onDelete 
}: ActionDropdownProps) {
  const dropdownRef = useRef<HTMLDivElement>(null);

  useEffect(() => {
    if (!isOpen) return;

    function handleClickOutside(event: MouseEvent) {
      if (dropdownRef.current && !dropdownRef.current.contains(event.target as Node)) {
        onToggle();
      }
    }

    // 添加延迟以避免立即触发
    setTimeout(() => {
      document.addEventListener('mousedown', handleClickOutside);
    }, 0);

    return () => {
      document.removeEventListener('mousedown', handleClickOutside);
    };
  }, [isOpen, onToggle]);

  return (
    <div className="relative" ref={dropdownRef}>
      <button 
        onClick={onToggle}
        className="p-2 hover:bg-gray-100 rounded-lg transition-colors"
        aria-label="Actions"
      >
        <MoreVertical className="w-4 h-4 text-gray-600" />
      </button>
      
      {isOpen && (
        <div className="absolute right-0 mt-1 w-40 bg-white rounded-lg shadow-lg border border-gray-200 py-1 z-10">
          {onView && (
            <button 
              onClick={onView}
              className="w-full px-4 py-2 text-left text-gray-700 hover:bg-gray-50 flex items-center gap-2"
            >
              <Eye className="w-4 h-4" />
              View
            </button>
          )}
          {onEdit && (
            <button 
              onClick={onEdit}
              className="w-full px-4 py-2 text-left text-gray-700 hover:bg-gray-50 flex items-center gap-2"
            >
              <Edit className="w-4 h-4" />
              Edit
            </button>
          )}
          {onDelete && (
            <button 
              onClick={onDelete}
              className="w-full px-4 py-2 text-left text-red-600 hover:bg-gray-50 flex items-center gap-2"
            >
              <Trash2 className="w-4 h-4" />
              Delete
            </button>
          )}
        </div>
      )}
    </div>
  );
}
