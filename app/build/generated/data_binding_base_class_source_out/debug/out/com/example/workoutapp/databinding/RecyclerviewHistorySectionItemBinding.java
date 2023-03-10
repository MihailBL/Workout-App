// Generated by view binder compiler. Do not edit!
package com.example.workoutapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.workoutapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class RecyclerviewHistorySectionItemBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btnDeleteCompletedExercises;

  @NonNull
  public final LinearLayout llHistorySectionItem;

  @NonNull
  public final TextView tvCompletedExerciseDate;

  @NonNull
  public final TextView tvItemId;

  private RecyclerviewHistorySectionItemBinding(@NonNull LinearLayout rootView,
      @NonNull Button btnDeleteCompletedExercises, @NonNull LinearLayout llHistorySectionItem,
      @NonNull TextView tvCompletedExerciseDate, @NonNull TextView tvItemId) {
    this.rootView = rootView;
    this.btnDeleteCompletedExercises = btnDeleteCompletedExercises;
    this.llHistorySectionItem = llHistorySectionItem;
    this.tvCompletedExerciseDate = tvCompletedExerciseDate;
    this.tvItemId = tvItemId;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static RecyclerviewHistorySectionItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static RecyclerviewHistorySectionItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.recyclerview_history_section_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static RecyclerviewHistorySectionItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_deleteCompletedExercises;
      Button btnDeleteCompletedExercises = ViewBindings.findChildViewById(rootView, id);
      if (btnDeleteCompletedExercises == null) {
        break missingId;
      }

      LinearLayout llHistorySectionItem = (LinearLayout) rootView;

      id = R.id.tv_completedExerciseDate;
      TextView tvCompletedExerciseDate = ViewBindings.findChildViewById(rootView, id);
      if (tvCompletedExerciseDate == null) {
        break missingId;
      }

      id = R.id.tv_itemId;
      TextView tvItemId = ViewBindings.findChildViewById(rootView, id);
      if (tvItemId == null) {
        break missingId;
      }

      return new RecyclerviewHistorySectionItemBinding((LinearLayout) rootView,
          btnDeleteCompletedExercises, llHistorySectionItem, tvCompletedExerciseDate, tvItemId);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
