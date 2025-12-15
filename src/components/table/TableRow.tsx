import { TableEntry } from '../../types/table';
import { StatusBadge } from './StatusBadge';
import { ProgressBar } from './ProgressBar';
import { ActionDropdown } from './ActionDropdown';

interface TableRowProps {
  entry: TableEntry;
  openDropdown: string | null;
  onToggleDropdown: (id: string) => void;
}

export function TableRow({ entry, openDropdown, onToggleDropdown }: TableRowProps) {
  const handleView = () => {
    console.log('View:', entry.id);
    onToggleDropdown(entry.id);
  };

  const handleEdit = () => {
    console.log('Edit:', entry.id);
    onToggleDropdown(entry.id);
  };

  const handleDelete = () => {
    console.log('Delete:', entry.id);
    onToggleDropdown(entry.id);
  };

  return (
    <tr className="hover:bg-gray-50 transition-colors">
      <td className="px-6 py-4 text-gray-900">#{entry.id}</td>
      <td className="px-6 py-4 text-gray-900">{entry.project}</td>
      <td className="px-6 py-4 text-gray-600">{entry.client}</td>
      <td className="px-6 py-4">
        <StatusBadge status={entry.status} />
      </td>
      <td className="px-6 py-4">
        <ProgressBar progress={entry.progress} />
      </td>
      <td className="px-6 py-4 text-gray-900">{entry.amount}</td>
      <td className="px-6 py-4 text-gray-600">{entry.date}</td>
      <td className="px-6 py-4">
        <ActionDropdown
          isOpen={openDropdown === entry.id}
          onToggle={() => onToggleDropdown(entry.id)}
          onView={handleView}
          onEdit={handleEdit}
          onDelete={handleDelete}
        />
      </td>
    </tr>
  );
}
